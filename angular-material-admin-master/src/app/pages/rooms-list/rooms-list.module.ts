import { CustomerBookingPageComponent } from './customer-booking-page/customer-booking-page.component';
import { CustomerBookingHistoryComponent } from './../customer-booking-history/customer-booking-history.component';
import { RoomsListComponent } from './rooms-list.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatNativeDateModule } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatStepperModule } from '@angular/material/stepper';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Routes, RouterModule } from '@angular/router';
import { SharedModule } from 'src/app/shared/shared.module';

const routes: Routes = [
  {
    path: '',
    component: RoomsListComponent
  },
  {
    path: 'booking/:id',
    component: CustomerBookingPageComponent
  }
  
];


@NgModule({
  declarations: [
    RoomsListComponent,
    CustomerBookingPageComponent
  ],
  imports: [
    FormsModule,
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
    MatDialogModule,
    MatTableModule,
    MatPaginatorModule,
  ],
  
  exports: [
    RouterModule,
    SharedModule,
    
  ],
  providers: [
    
  ]
})
export class RoomsListModule { }
