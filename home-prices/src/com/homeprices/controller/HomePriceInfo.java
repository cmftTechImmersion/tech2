package com.homeprices.controller;

public class HomePriceInfo
{
    private String baths;

    private String zip;

    private String price;

    private String beds;

    private String saledt;

    private String street;

    private String state;

    private String longitude;

    private String latitude;

    private String type;

    private String sqft;

    private String city;

    public String getBaths ()
    {
        return baths;
    }

    public void setBaths (String baths)
    {
        this.baths = baths;
    }

    public String getZip ()
    {
        return zip;
    }

    public void setZip (String zip)
    {
        this.zip = zip;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getBeds ()
    {
        return beds;
    }

    public void setBeds (String beds)
    {
        this.beds = beds;
    }

    public String getSaledt ()
    {
        return saledt;
    }

    public void setSaledt (String saledt)
    {
        this.saledt = saledt;
    }

    public String getStreet ()
    {
        return street;
    }

    public void setStreet (String street)
    {
        this.street = street;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getSqft ()
    {
        return sqft;
    }

    public void setSqft (String sqft)
    {
        this.sqft = sqft;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [baths = "+baths+", zip = "+zip+", price = "+price+", beds = "+beds+", saledt = "+saledt+", street = "+street+", state = "+state+", longitude = "+longitude+", latitude = "+latitude+", type = "+type+", sqft = "+sqft+", city = "+city+"]";
    }
}
