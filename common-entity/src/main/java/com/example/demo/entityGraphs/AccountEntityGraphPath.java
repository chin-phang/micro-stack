package com.example.demo.entityGraphs;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.example.demo.entity.AccountEntityGraph;

public enum AccountEntityGraphPath {

  AccountWithUser {
    @Override
    public EntityGraph getEntityGraph() {
      return AccountEntityGraph.____().user().____.____();
    }
  },
  AccountWithProfile {
    @Override
    public EntityGraph getEntityGraph() {
      return AccountEntityGraph.____().profile().____.____();
    }
  },
  AccountWithBalance {
    @Override
    public EntityGraph getEntityGraph() {
      return AccountEntityGraph.____().balance().____.____();
    }
  },
  AccountWithUserAndProfileAndBalance {
    @Override
    public EntityGraph getEntityGraph() {
      return AccountEntityGraph.____().user().____.profile().____.balance().____.____();
    }
  };

  public abstract EntityGraph getEntityGraph();
}
