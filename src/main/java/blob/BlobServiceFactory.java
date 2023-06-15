package blob;

import com.azure.core.credential.TokenCredential;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import configuration.BlobServiceConfiguration;
import io.micronaut.context.annotation.Factory;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;

@Factory
public class BlobServiceFactory {

    @Singleton
    public BlobServiceClient blobServiceClient(@NonNull TokenCredential tokenCredential, @NonNull BlobServiceConfiguration blobServiceConfiguration){
        return new BlobServiceClientBuilder()
                .endpoint(blobServiceConfiguration.getEndpoint())
                .buildClient();
    }
}