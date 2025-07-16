package com.example.demo.entityGraphs;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.example.demo.entity.UserEntityGraph;

public enum UserEntityGraphPath {

  UserWithRoles {
    @Override
    public EntityGraph getEntityGraph() {
      return UserEntityGraph.____().roles().____.____();
    }
  },
  UserWithAccounts {
    @Override
    public EntityGraph getEntityGraph() {
      return UserEntityGraph.____().accounts().____.____();
    }
  },
  UserWithRolesAndAccounts {
    @Override
    public EntityGraph getEntityGraph() {
      return UserEntityGraph.____().roles().____.accounts().____.____();
    }
  };

  public abstract EntityGraph getEntityGraph();
}
