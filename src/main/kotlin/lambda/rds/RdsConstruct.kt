package lambda.rds

import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.core.Duration
import software.amazon.awscdk.services.rds.*
import software.amazon.awscdk.services.secretsmanager.Secret
import software.amazon.awscdk.services.secretsmanager.SecretProps

class RdsConstruct(
        scope: Construct,
        id: String,
        properties: RdsProperties
) : Construct(scope, id) {
    val instance: DatabaseInstance

    init {

        instance = DatabaseInstance(this, "Database", DatabaseInstanceProps.builder()
                .engine(DatabaseInstanceEngine.mysql(MySqlInstanceEngineProps.builder().version(MysqlEngineVersion.VER_5_7).build()))
                .instanceType(properties.instanceType)
                .storageEncrypted(properties.storageEncrypted)
                .vpc(properties.vpc)
                .availabilityZone(properties.masterAvailabilityZone)
                .databaseName(properties.databaseName)
                .backupRetention(Duration.days(properties.backupRetentionInDays))
                .instanceIdentifier(properties.masterInstanceIdentifier)
                .credentials(Credentials.fromSecret(DatabaseSecret(this, "DatabaseSecret", DatabaseSecretProps.builder()
                        .username(properties.masterUsername)
                        .masterSecret(Secret(this, "Secret", SecretProps.builder()
                                .secretName(properties.secretName)
                                .build()))
                        .build()
                )))
                .build()
        )

        //databaseSecret.attach(instance)

        instance.addRotationSingleUser()
    }
}