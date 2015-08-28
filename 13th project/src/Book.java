public class Book {

private String title;
private String author;
private String description;
private double price;
private int isInStock;

private int nums;

public Book()
{
title = "";
author = "";
description = "";
price = 0;
isInStock = 0;
}

public void setTitle(String title)
{
this.title = title;
}

public String getTitle()
{
return title; 
}

public void setAuthor(String author)
{
this.author = author;
}

public String getAuthor()
{
return author; 
}

public void setDescription(String description)
{
this.description = description;
}

public String getDescription()
{
return description; 
}

public void setPrice(double price)
{
this.price = price;
}

public double getPrice()
{
return price; 
}


public int stockAvailable()
{
if(isInStock == 1)
return 1;
else
return 0;
}
}