# Practical part

There's a tester for the DiscountTypeTester in the test folder.

# Question

When using strategy SINGLE_TABLE there is only one table in the database for all 3 classes:

    DISCOUNTTYPE
    ---------
    ID
    DTYPE (discriminator)
    QUANTITYFORDISCOUNT (nullable)
    DISCOUNT (nullable)
    
 
If we change it to JOINED strategy we have one table for each class: DiscountType, DiscountQuantity and FixedDiscount:

    DISCOUNTTYPE            FIXEDDISCOUNT       DISCOUNTQUANTITY
    ---------               --------------      -------------
    ID                      DISCOUNT            DISCOUNT
    DTYPE (discriminator)                       QUANTITYFORDISCOUNT
    
And attributes in subclasses do not need to be nullable
