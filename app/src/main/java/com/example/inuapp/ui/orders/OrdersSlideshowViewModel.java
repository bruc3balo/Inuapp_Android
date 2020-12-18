package com.example.inuapp.ui.orders;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inuapp.models.Orders;
import com.example.inuapp.models.Products;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.example.inuapp.models.Orders.ORDERED_AT;
import static com.example.inuapp.models.Orders.ORDERS;
import static com.example.inuapp.models.Orders.ORDER_AMOUNT;
import static com.example.inuapp.models.Orders.ORDER_NO;
import static com.example.inuapp.models.Orders.PRODUCTS_ORDERED;
import static com.example.inuapp.models.User.UID;

public class OrdersSlideshowViewModel extends ViewModel {

    private MutableLiveData<Orders> ordersMutableLiveData;

    public OrdersSlideshowViewModel() {
        getOrdersMutableLiveData();
    }

    private MutableLiveData<Orders> getOrdersMutableLiveData() {
        ordersMutableLiveData = new MutableLiveData<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection(ORDERS).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (int i = 0; i <= Objects.requireNonNull(task.getResult()).size() - 1; i++) {
                    List<Map<String, Products>> productsList = (List<Map<String, Products>>) task.getResult().getDocuments().get(i).get(PRODUCTS_ORDERED);
                    String orderAmount = Objects.requireNonNull(task.getResult().getDocuments().get(i).get(ORDER_AMOUNT)).toString();
                    String orderedAt = Objects.requireNonNull(task.getResult().getDocuments().get(i).get(ORDERED_AT)).toString();
                    String orderNo = Objects.requireNonNull(task.getResult().getDocuments().get(i).get(ORDER_NO)).toString();
                    String userId = Objects.requireNonNull(task.getResult().getDocuments().get(i).get(UID)).toString();

                    Orders orders = new Orders();
                    orders.setOrderNo(orderNo);
                    orders.setOrderAmount(orderAmount);
                    orders.setUserId(userId);
                    orders.setOrderedAt(orderedAt);
                   // LinkedList<Products> prodList = new LinkedList<>((Collection<? extends Products>) productsList);
                    orders.setProductsOrdered(productsList);
                    ordersMutableLiveData.setValue(orders);
                    System.out.println(productsList);
                }
            } else {
                System.out.println("Failed to get data");
            }
        });
        return ordersMutableLiveData;
    }

    public LiveData<Orders> getOrdersList() {
        return getOrdersMutableLiveData();
    }

}