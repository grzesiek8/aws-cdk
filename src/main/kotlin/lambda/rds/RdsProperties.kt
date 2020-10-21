package lambda.rds

import software.amazon.awscdk.services.ec2.ISecurityGroup
import software.amazon.awscdk.services.ec2.IVpc
import software.amazon.awscdk.services.ec2.InstanceClass
import software.amazon.awscdk.services.ec2.InstanceSize
import software.amazon.awscdk.services.ec2.InstanceType

/**
 * Configuration class for Relational Database Service (RDS)
 */
class RdsProperties(
        /**
         * Base name of created resource e.g. "team.environment.name"
         */
        val baseName: String,

        /**
         * The VPC network where the DB subnet group should be created.
         */
        val vpc: IVpc,

        /**
         * The master user name
         */
        val masterUsername: String = "admin",

        /**
         * The name of the secret.
         */
        val secretName: String?,

        /**
         *  Master availability zone
         */
        val masterAvailabilityZone: String = "us-east-1a",

        /**
         * Name od the database to be created
         */
        val databaseName: String,

        /**
         *  A name for the DB replica instance. If you specify a name, AWS CloudFormation converts it to lowercase.
         */
        val masterInstanceIdentifier: String,

        /**
         * The number of days during which automatic DB snapshots are retained.
         * Set to zero to disable backups.
         */
        val backupRetentionInDays: Int = 30,

        /**
         * Indicates whether the DB instance is encrypted.
         */
        val storageEncrypted: Boolean = true,

        /**
         * The name of the compute and memory capacity for the instance.
         */
        val instanceType: InstanceType = InstanceType.of(InstanceClass.BURSTABLE3, InstanceSize.SMALL)

)