import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';



@Component({
  selector: 'dialog-elements-example-dialog',
  templateUrl: 'dialog-elements-example-dialog.html',
})
export class DialogElementsExampleDialog {

  constructor(public dialog: MatDialog) {}

  closeDialog() {
    this.dialog.closeAll();
  }

}


@Component({
  selector: 'app-service-request',
  templateUrl: './service-request.component.html',
  styleUrls: ['./service-request.component.css']
})
export class ServiceRequestComponent implements OnInit {


  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;



  

  constructor(private _formBuilder: FormBuilder,public dialog: MatDialog) {}

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
  }



  openDialog() {
    this.dialog.open(DialogElementsExampleDialog);
  }
}

