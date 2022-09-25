package utils;

import pagesObjects.PageObjectManager;

public class TestContextSetup {
    public PageObjectManager pageObjectManager;
    public Base base;
    public TestContextSetup(){
        this.base = new Base();
        this.pageObjectManager = new PageObjectManager(this.base.WebDriverManager());
    }
}
