package org.acme;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

public class InMemoryEmbeddingStoreFactory {

    @Produces
    @Singleton
    public EmbeddingStore<TextSegment> create() {
        return new InMemoryEmbeddingStore<>();
    }

}
