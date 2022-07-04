package br.com.dev.superheroes.application.config

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableDynamoDBRepositories(basePackages = ["br.com.dev.superheroes.infra.repository"])
class DynamoDBConfig {
    @Value("\${amazon.dynamodb.endpoint}")
    private val amazonDynamoDBEndpoint: String? = null

    @Value("\${amazon.aws.accesskey}")
    private val amazonAWSAccessKey: String? = null

    @Value("\${amazon.aws.secretkey}")
    private val amazonAWSSecretKey: String? = null

    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB {
        val amazonDynamoDB: AmazonDynamoDB = AmazonDynamoDBClient(amazonAWSCredentials())
        if (amazonDynamoDBEndpoint != null && amazonDynamoDBEndpoint != "") {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint)
        }
        return amazonDynamoDB
    }

    @Bean
    fun amazonAWSCredentials(): AWSCredentials {
        return BasicAWSCredentials(
            amazonAWSAccessKey, amazonAWSSecretKey
        )
    }
}