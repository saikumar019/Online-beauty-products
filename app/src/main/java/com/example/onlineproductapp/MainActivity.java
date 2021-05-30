package com.example.onlineproductapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.onlineproductapp.adapter.ProductAdapter;
import com.example.onlineproductapp.adapter.ProductCategoryAdapter;
import com.example.onlineproductapp.model.ProductCategory;
import com.example.onlineproductapp.model.Products;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, prodItemRecycler;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(new ProductCategory(1, "Most popular"));
        productCategoryList.add(new ProductCategory(2, "All Body Products"));
        productCategoryList.add(new ProductCategory(3, "Hair"));
        productCategoryList.add(new ProductCategory(4, "Face"));
        productCategoryList.add(new ProductCategory(5, "Skincare"));
        setProductRecycler(productCategoryList);

        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "Herbal Shampoo", "250ml", "RS $320", R.drawable.pd1));
        productsList.add(new Products(2, "De-Saline", "290ml", "RS $390", R.drawable.pd2));
        productsList.add(new Products(1, "Head&Shoulder", "200ml", "RS $300", R.drawable.pd3));
        productsList.add(new Products(2, "Elements", "300ml", "RS $280", R.drawable.pd4));
        productsList.add(new Products(2, "Face care", "290ml", "RS $180", R.drawable.pd5));
        productsList.add(new Products(2, "Redken", "300ml", " RS $480", R.drawable.pd6));
        setProdctItemRecycler(productsList);
    }

    private void setProductRecycler(List<ProductCategory> productCategoryList) {
        productCatRecycler = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);
    }

    private void setProdctItemRecycler(List<Products> productsList) {
        prodItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);
    }
}