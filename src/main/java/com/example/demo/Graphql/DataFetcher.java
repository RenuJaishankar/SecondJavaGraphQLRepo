package com.example.demo.Graphql;
import graphql.schema.DataFetchingEnvironment;
public interface DataFetcher<T> {
    T get (DataFetchingEnvironment dataFetchingEnvironment) throws Exception;
}
