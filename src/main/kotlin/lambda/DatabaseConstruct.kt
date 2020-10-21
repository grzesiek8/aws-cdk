package lambda

import lambda.rds.RdsConstruct
import lambda.rds.RdsProperties
import lambda.vpc.VpcConstruct
import lambda.vpc.VpcProperties
import lambda.vpc.VpcSettings
import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.services.ec2.SecurityGroup
import software.amazon.awscdk.services.ec2.Vpc
import software.amazon.awscdk.services.ec2.VpcAttributes
import software.amazon.awscdk.services.ec2.VpcProps

class DatabaseConstruct(scope: Construct, id: String, stage: String) : Construct(scope, id) {
    init {
        val vpc = Vpc.fromVpcAttributes(this,"Vpc",VpcAttributes.builder()
                .vpcId("vpc-e15b999c")
                .availabilityZones(listOf("us-east-1"))
                .privateSubnetIds(listOf("subnet-46ba0819","subnet-a01dabc6"))
                .build())
        val baseName = "someBaseName"
        val instancesPrefix = "pca-crashdocs"


        RdsConstruct(
                scope = this,
                id = "Rds",
                properties = RdsProperties(
                        baseName = baseName,
                        databaseName = "crashdocs",
                        masterInstanceIdentifier = "$instancesPrefix-writer",
                        vpc = vpc,
                        secretName = "pca/crashdocs/test_alpha"
                )
        )

    }
}