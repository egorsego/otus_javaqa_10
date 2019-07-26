package com.otus.testdata;

public class Contact {
    protected String contactType;
    protected String contactValue;

    public Contact(String contactType, String contactValue) {
        this.contactType = contactType;
        this.contactValue = contactValue;
    }

    public String getContactType() {
        return contactType;
    }

    public String getContactValue() {
        return contactValue;
    }

    @Override
    public String toString(){
        return String.format("%s: %s", contactType, contactValue);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass() != this.getClass())
            return false;

        Contact contact = (Contact) obj;
        return contact.contactType.equals(this.contactType) && contact.contactValue.equals(this.contactValue);
    }

    @Override
    public int hashCode()
    {
        String concat = contactType + contactValue;
        return concat.hashCode();
    }
}
