import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerBookingPageComponent } from './customer-booking-page.component';

describe('CustomerBookingPageComponent', () => {
  let component: CustomerBookingPageComponent;
  let fixture: ComponentFixture<CustomerBookingPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerBookingPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerBookingPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
