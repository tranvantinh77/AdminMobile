package com.example.adminpage;

import android.content.Context;
import android.content.Intent;

public class Function {

    /**
     * Trang chủ
     */
    public static void goToMainActivity(Context context) {
        Intent myIntent = new Intent(context, MainActivity.class);
        context.startActivity(myIntent);
    }

    /**
     * Quản lý Đơn hàng
     */
    // Quản lý đơn hàng
    public static void goToActivityOrder(Context context) {
        Intent myIntent = new Intent(context, ActivityOrder.class);
        context.startActivity(myIntent);
    }

    /**
     * Quản lý Danh mục
     */
    // Quản lý danh mục
    public static void goToActivityCategory(Context context) {
        Intent myIntent = new Intent(context, ActivityCategory.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Danh sách danh mục
    public static void goToActivityCategoryList(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryList.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Thêm danh mục
    public static void goToActivityCategoryAdd(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryAdd.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Danh sách danh mục -> Danh sách điện thoại
    public static void goToActivityCategoryListPhone(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryListPhone.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Danh sách danh mục -> Danh sách laptop
    public static void goToActivityCategoryListLaptop(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryListLaptop.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Danh sách danh mục -> Danh sách phụ kiện
    public static void goToActivityCategoryListAccessories(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryListAcce.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Danh sách danh mục -> Danh sách điện thoại -> Thêm Product
    public static void goToActivityAddProduct(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryAddProduct.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Danh sách danh mục -> Danh sách điện thoại -> Sửa product
    public static void goToActivityEditProduct(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryEditProduct.class);
        context.startActivity(myIntent);
    }

    /**
     * Quản lý Người dùng
     */
    // Quản lý người dùng
    public static void goToActivityUser(Context context) {
        Intent myIntent = new Intent(context, ActivityUser.class);
        context.startActivity(myIntent);
    }
}
