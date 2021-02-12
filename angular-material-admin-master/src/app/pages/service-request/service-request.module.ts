import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ServiceRequestComponent, DialogElementsExampleDialog } from './component/service-request/service-request.component';
import { ServiceRequestService } from './service/service-request.service';
import { Routes, RouterModule } from '@angular/router';
import { SharedModule } from 'src/app/shared/shared.module';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatStepperModule} from '@angular/material/stepper';
import { ReactiveFormsModule } from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import {MatRadioModule} from '@angular/material/radio';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatSelectModule} from '@angular/material/select';
import {MatDialogModule} from '@angular/material/dialog';


const routes: Routes = [
  {
    path: '',
    component: ServiceRequestComponent
  }
];



@NgModule({
  declarations: [
    ServiceRequestComponent,
    DialogElementsExampleDialog
  ],
  imports: [
    CommonModule,
    MatCardModule,
    MatToolbarModule,
    SharedModule,
    MatStepperModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatIconModule,
    RouterModule.forChild(routes),
    MatButtonModule,
    MatInputModule,
    MatRadioModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatDialogModule
  ],
  
  exports: [
    RouterModule,
    SharedModule,
    
  ],
  providers: [
    ServiceRequestService
  ]
})
export class ServiceRequestModule { }
