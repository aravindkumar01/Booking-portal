import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { AuthPageComponent } from './containers';
import { HttpClientModule } from '@angular/common/http';

const routes: Routes = [
  {
    path: '',
    component: AuthPageComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
    ,HttpClientModule
  ],
  
  exports: [RouterModule,
  ]
})

export class AuthRoutingModule {
}
