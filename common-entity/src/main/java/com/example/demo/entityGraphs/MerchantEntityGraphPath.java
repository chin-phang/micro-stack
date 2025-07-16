package com.example.demo.entityGraphs;

import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.example.demo.entity.MerchantEntityGraph;

public enum MerchantEntityGraphPath {

  MerchantWithParent {
    @Override
    public EntityGraph getEntityGraph() {
      return MerchantEntityGraph.____().parent().____.____();
    }
  },
  MerchantWithChildren {
    @Override
    public EntityGraph getEntityGraph() {
      return MerchantEntityGraph.____().children().____.____();
    }
  },
  MerchantWithParentAndChildren {
    @Override
    public EntityGraph getEntityGraph() {
      return MerchantEntityGraph.____().parent().____.children().____.____();
    }
  };

  public abstract EntityGraph getEntityGraph();
}
