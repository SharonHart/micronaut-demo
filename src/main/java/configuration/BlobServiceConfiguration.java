package configuration;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Data;

@Data
@ConfigurationProperties("azure.blob")
public class BlobServiceConfiguration {

    String container;
    String endpoint;

}
