package com.example.inuapp.ui.explore;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inuapp.models.Products;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.Objects;

import static com.example.inuapp.models.Products.POSTED_AT;
import static com.example.inuapp.models.Products.PRODUCTS;
import static com.example.inuapp.models.Products.PRODUCT_CATEGORY;
import static com.example.inuapp.models.Products.PRODUCT_DESCRIPTION;
import static com.example.inuapp.models.Products.PRODUCT_ID;
import static com.example.inuapp.models.Products.PRODUCT_IMAGE_URL;
import static com.example.inuapp.models.Products.PRODUCT_MP;
import static com.example.inuapp.models.Products.PRODUCT_NAME;
import static com.example.inuapp.models.Products.PRODUCT_SP;
import static com.example.inuapp.models.Products.PRODUCT_UNIT;

public class ExploreViewModel extends ViewModel {

    private MutableLiveData<Products> productsMutable;

    public ExploreViewModel() {

    }

    public MutableLiveData<Products> getProducts() {
        productsMutable = new MutableLiveData<>();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection(PRODUCTS).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {

                List<DocumentSnapshot> ds = Objects.requireNonNull(task.getResult()).getDocuments();

                for (int i = 0; i <= ds.size() - 1; i++) {
                    Products products = new Products();
                    String postedAt = Objects.requireNonNull(ds.get(i).get(POSTED_AT)).toString();
                    products.setPostedAt(postedAt);

                    String prodCat = Objects.requireNonNull(ds.get(i).get(PRODUCT_CATEGORY)).toString();
                    products.setProductCategory(prodCat);

                    String prodDesc = Objects.requireNonNull(ds.get(i).get(PRODUCT_DESCRIPTION)).toString();
                    products.setProductDescription(prodDesc);

                    String prodId = Objects.requireNonNull(ds.get(i).get(PRODUCT_ID)).toString();
                    products.setProductId(prodId);

                    String prodImage = Objects.requireNonNull(ds.get(i).get(PRODUCT_IMAGE_URL)).toString();
                    products.setProductImageUrl(prodImage);

                    Double prodMP = Double.parseDouble(Objects.requireNonNull(ds.get(i).get(PRODUCT_MP)).toString());
                    products.setProductMarketPricePerUnit(prodMP);

                    String prodName = Objects.requireNonNull(ds.get(i).get(PRODUCT_NAME)).toString();
                    products.setProductName(prodName);

                    Double prodSp = Double.parseDouble(Objects.requireNonNull(ds.get(i).get(PRODUCT_SP)).toString());
                    products.setProductSellingPricePerUnit(prodSp);

                    String prodUnit = Objects.requireNonNull(ds.get(i).get(PRODUCT_UNIT)).toString();
                    products.setProductUnit(prodUnit);

                    productsMutable.setValue(products);
                }
            } else {
                String fail = "Failed to get products";
                System.out.println(fail);
                productsMutable.setValue(new Products(fail));
            }
        });
        return productsMutable;
    }

    public LiveData<Products> getProductsData() {
        return getProducts();
    }
}