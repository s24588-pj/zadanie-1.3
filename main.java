package pl.pjait;

import model.Invoice;
import model.InvoicePosition;
import model.Product;

public class Main {

    public static void main(String[] args) {

        Invoice invoice = new Invoice();
        invoice.addPosition(new Product("ABC123", "Tv", 1000));
        invoice.addPosition(new Product("ABC123", "Tv", 1000));
        invoice.addPosition(new Product("CBA321", "Radio", 500));
        invoice.addPosition(new Product("ABC123", "Tv", 1000));
        invoice.addPosition(new Product("CBA321", "Radio", 500));
        printoutInvoice(invoice);

        System.out.println("Stawka VAT: " + InvoicePosition.TAX_5);
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_8);
        System.out.println("Stawka VAT: " + InvoicePosition.TAX_23);

    }

    private static void printoutInvoice(Invoice invoice){
        System.out.println("|NAZWA\t|ILOSC\t|CENA NETTO\t|CENA BRUTTO\t|STAWKA VAT\t|PODATEK");
        System.out.println("*******************************************************************");
        for (InvoicePosition p : invoice.getPositions()){
            System.out.print("|" + p.getProduct().getName() + "\t\t|");
            System.out.print(p.getCount() + "\t\t|");
            System.out.print(p.getNettoPrice() + "\t\t|");
            System.out.print(p.getGrossPrice() + "\t\t\t|");
            System.out.print(p.getTax() + "\t\t|");
            System.out.println(p.getTaxValue());
            System.out.println("-------------------------------------------------------------------");
        }
    }
}
