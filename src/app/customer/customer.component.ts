import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent {


  CustomerArray : any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;
 
  
  custName: string ="";
  custAddress: string ="";
  email : string = "";
  password : string = "";
  phoneNumber: Number = 0;
  currentCustomerID = "";

  constructor(private http: HttpClient )
  {
    this.getAllCustomer();
 
  }

  ngOnInit(): void {
  }
 
  getAllCustomer()
  {
    this.http.get("http://localhost:8080/api/v1/customer/getAll").subscribe((resultData: any)=>
    {
        this.isResultLoaded = true;
        console.log(resultData);
        this.CustomerArray = resultData;
    });
  }
 
  register()
  {
    let bodyData = {
      "custName" : this.custName,
      "custAddress" : this.custAddress,
      "email": this.email,
      "password":this.password,
      "phoneNumber" : this.phoneNumber 
    };

    this.http.post("http://localhost:8080/api/v1/customer/save",bodyData, {responseType : 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Customer Registered Successfully")
        this.getAllCustomer();
        this.custName = '';
        this.custAddress = '';
        this.email = '';
        this.password='';
        this.phoneNumber  = 0;
    });
  }
 

  setUpdate(data: any)
  {
   this.custName = data.custName;
   this.custAddress = data.custAddress;
   this.email = data.email;
   this.password = data.password;
   this.phoneNumber = data.phoneNumber;
   this.currentCustomerID = data.custId;
  }
 

  UpdateRecords()
  {
    let bodyData = {
      "custId" : this.currentCustomerID,
      "custName" : this.custName,
      "custAddress" : this.custAddress,
      "email":this.email,
      "password":this.password,
      "phoneNumber" : this.phoneNumber,
    };
    
    this.http.put("http://localhost:8080/api/v1/customer/update",bodyData, {responseType : 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Customer Updated Successfully!")
        this.getAllCustomer();
        this.custName = '';
        this.custAddress = '';
        this.email = '';
        this.password='';
        this.phoneNumber  = 0;
    });
  }


  save()
  {
    if(this.currentCustomerID == '')
    {
        this.register();
    }
      else
      {
       this.UpdateRecords();
      }      
 
  }
 
 
  setDelete(data: any)
  {
    
    
    this.http.delete("http://localhost:8080/api/v1/customer/deletecustomer"+ "/"+ data.custId,{responseType: 'text'}).subscribe((resultData: any)=>
    {
        console.log(resultData);
        alert("Customer Deletedddd")
        this.getAllCustomer();
        this.custName = '';
        this.custAddress = '';
        this.email = '';
        this.password='';
        this.phoneNumber  = 0;
    });
 
  }

 

}
