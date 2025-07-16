package com.example.demo.entityGraphs;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.example.demo.entity.AccountProfileEntityGraph;

public enum AccountProfileEntityGraphPath {

  AccountProfileWithAccount {
    @Override
    public EntityGraph getEntityGraph() {
      return AccountProfileEntityGraph.____().account().____.____();
    }
  };

  public abstract EntityGraph getEntityGraph();
}
