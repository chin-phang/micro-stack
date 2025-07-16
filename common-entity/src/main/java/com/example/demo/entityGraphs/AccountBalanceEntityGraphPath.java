package com.example.demo.entityGraphs;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.example.demo.entity.AccountBalanceEntityGraph;

public enum AccountBalanceEntityGraphPath {

  AccountBalanceWithAccount {
    @Override
    public EntityGraph getEntityGraph() {
      return AccountBalanceEntityGraph.____().account().____.____();
    }
  };

  public abstract EntityGraph getEntityGraph();
}
