package org.acme;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.rag.DefaultRetrievalAugmentor;
import dev.langchain4j.rag.RetrievalAugmentor;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.function.Supplier;

@ApplicationScoped
public class AugmentatorCarsInformation implements Supplier<RetrievalAugmentor> {

    private final EmbeddingStoreContentRetriever retriever;

    AugmentatorCarsInformation(EmbeddingStore<TextSegment> store, dev.langchain4j.model.embedding.AllMiniLmL6V2QuantizedEmbeddingModel model) {
        retriever = EmbeddingStoreContentRetriever.builder()
                .embeddingModel(model)
                .embeddingStore(store)
                .maxResults(20)
                .build();
    }

    @Override
    public RetrievalAugmentor get() {
        return DefaultRetrievalAugmentor.builder()
                .contentRetriever(retriever)
                .build();
    }
}
