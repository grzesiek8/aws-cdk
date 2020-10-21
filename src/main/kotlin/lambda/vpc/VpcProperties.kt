package lambda.vpc

/**
 * Configuration class for Virtual Private Cloud (VPC)
 */
class VpcProperties (
        /**
     * VPC settings to be used
     */
    val vpc: VpcSettings,
        /**
     * List of subnet settings to be used
     */
    val subnets: List<SubnetSettings>
)

data class VpcSettings(
    /**
     * Id of the VPC
     */
    val id: String,
    /**
     * Name of the VPC
     */
    val name: String = "BaseVpc",
    /**
     * Id of the security group
     */
    val securityGroupId: String
)

data class SubnetSettings(
    /**
     * Id of the subnet
     */
    val subnetId: String,
    /**
     * Availability zone for the subnet in this VPC
     */
    val availabilityZone: String
)