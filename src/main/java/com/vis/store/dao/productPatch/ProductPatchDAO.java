package com.vis.store.dao.productPatch;

import stationary.store.model.ProductPatch;

import java.util.List;

public interface ProductPatchDAO {

    List<ProductPatch> getProductPatches();

    void saveProductPatch(ProductPatch ProductPatch);

    ProductPatch getProductPatch(int id);

    void deleteProductPatch(int id);

}
