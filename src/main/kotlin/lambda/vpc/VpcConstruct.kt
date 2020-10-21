package lambda.vpc

import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.services.ec2.Vpc
import software.amazon.awscdk.services.ec2.IVpc
import software.amazon.awscdk.services.ec2.VpcAttributes

class VpcConstruct(
    scope: Construct,
    id: String,
    properties: VpcProperties
) : Construct(scope, id) {
    val vpc: IVpc
    init {
        vpc = Vpc.fromVpcAttributes(this, properties.vpc.name, VpcAttributes.builder()
            .vpcId(properties.vpc.id)
            .availabilityZones(properties.subnets.map { it.availabilityZone })
            .privateSubnetIds(properties.subnets.map { it.subnetId })
            .build()
        )
    }
}