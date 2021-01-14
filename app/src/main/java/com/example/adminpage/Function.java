package com.example.adminpage;

import android.content.Context;
import android.content.Intent;

public class Function {

    public Function() {

    }

    /**
     * Quản lý Đơn hàng
     */
    // Quản lý đơn hàng
    public void goToActivityOrder(Context context) {
        Intent myIntent = new Intent(context, ActivityOrder.class);
        context.startActivity(myIntent);
    }

    /**
     * Quản lý Danh mục
     */
    // Quản lý danh mục
    public void goToActivityCategory(Context context) {
        Intent myIntent = new Intent(context, ActivityCategory.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Danh sách danh mục
    public void goToActivityCategoryList(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryList.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Thêm danh mục
    public void goToActivityCategoryAdd(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryAdd.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Danh sách danh mục -> Danh sách điện thoại
    public void goToActivityCategoryListPhone(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryListPhone.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Danh sách danh mục -> Danh sách laptop
    public void goToActivityCategoryListLaptop(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryListLaptop.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Danh sách danh mục -> Danh sách phụ kiện
    public void goToActivityCategoryListAccessories(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryListAcce.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Danh sách danh mục -> Danh sách điện thoại -> Thêm điện thoại
    public void goToActivityCategoryAddPhone(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryAddPhone.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Danh sách danh mục -> Danh sách điện thoại -> Thêm laptop
    public void goToActivityCategoryAddLaptop(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryAddLaptop.class);
        context.startActivity(myIntent);
    }

    // Quản lý danh mục -> Danh sách danh mục -> Danh sách điện thoại -> Thêm phụ kiện
    public void goToActivityCategoryAddAcce(Context context) {
        Intent myIntent = new Intent(context, ActivityCategoryAddAcce.class);
        context.startActivity(myIntent);
    }


    /**
     * Quản lý Người dùng
     */
    // Quản lý người dùng
    public void goToActivityUser(Context context) {
        Intent myIntent = new Intent(context, ActivityUser.class);
        context.startActivity(myIntent);
    }
}
