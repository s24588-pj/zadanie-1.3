package model;

import java.util.ArrayList;

public class Invoice {

    private String buyer;
    private String seller;
    private String dateOfIssue;
    private String dateOfPayment;

//    public Invoice(String buyer, String seller, String dateOfIssue, String dateOfPayment) {
//        this.buyer = buyer;
//        this.seller = seller;
//        this.dateOfIssue = dateOfIssue;
//        this.dateOfPayment = dateOfPayment;
//    }

    private ArrayList<InvoicePosition> positions = new ArrayList<InvoicePosition>();

    public ArrayList<InvoicePosition> getPositions(){
        return positions;
    }

    private InvoicePosition positionWithProduct(Product product){
        for(InvoicePosition position : positions){
            if(position.getProduct().getCode().equals(product.getCode()))
                return position;
        }
        return null;
    }

    public void addPosition(Product product){
        InvoicePosition position = positionWithProduct(product);
        if(position == null){
            addPosition(new InvoicePosition(product));
            return;
        }
        position.setCount(position.getCount()+1);
    }

}
