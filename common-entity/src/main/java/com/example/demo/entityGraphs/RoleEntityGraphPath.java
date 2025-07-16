package com.example.demo.entityGraphs;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.example.demo.entity.RoleEntityGraph;

public enum RoleEntityGraphPath {

  RoleWithUsers {
    @Override
    public EntityGraph getEntityGraph() {
      return RoleEntityGraph.____().users().____.____();
    }
  };

  public abstract EntityGraph getEntityGraph();
}
