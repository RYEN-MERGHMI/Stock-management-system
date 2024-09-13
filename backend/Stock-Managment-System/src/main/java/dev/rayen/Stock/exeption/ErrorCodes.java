package dev.rayen.Stock.exeption;

public enum ErrorCodes {

    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    ARTICLE_ALREADY_IN_USE(1002),

    CATEGORY_NOT_FOUND(2000),
    CATEGORY_NOT_VALID(2001),
    CATEGORY_ALREADY_IN_USE(2002),


    CLIENT_NOT_FOUND(3000),
    CLIENT_NOT_VALID(3001),
    CLIENT_ALREADY_IN_USE(3002),


    ORDER_CLIENT_NOT_FOUND(4000),
    ORDER_CLIENT_NOT_VALID(4001),
    ORDER_CLIENT_NON_MODIFIABLE(4002),
    ORDER_CLIENT_ALREADY_IN_USE(4003),


    ORDER_SUPPLIER_NOT_FOUND(5000),

    COMPANY_NOT_FOUND(6000),
    COMPANY_NOT_VALID(6001),

    SUPPLIER_NOT_FOUND(7000),
    SUPPLIER_NOT_VALID(7001),
    SUPPLIER_ALREADY_IN_USE(7002),


    CLIENT_CODE_LINE_NOT_FOUND(8000),
    SUPPLIER_CODE_LINE_NOT_FOUND(9000),
    SALE_LINE_NOT_FOUND(1000),
    STCK_MVMNT_NOT_FOUND(11000),

    USERS_NOT_FOUND(12000),
    USERS_NOT_VALID(12001),
    USERS_ALREADY_EXISTS(12002),


    BAD_CREDENTIALS(12003),

    SALE_NOT_FOUND(13000);



    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
