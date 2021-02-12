import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import { NgModule } from '@angular/core';
import { DashboardPageComponent } from './pages/dashboard/containers';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import {AuthGuard} from './pages/auth/guards';

const routes: Routes = [
  {
    path: 'dashboard',
    //pathMatch: 'full',
    canActivate: [AuthGuard],
    component: DashboardPageComponent
  },
  
  {
    path: 'customer',
    canActivate: [AuthGuard],
    //pathMatch: 'full',
    loadChildren: () => import('./pages/rooms-list/rooms-list.module').then(m => m.RoomsListModule)
  },
  {
    path: 'customer-history',
    canActivate: [AuthGuard],
    //pathMatch: 'full',
    loadChildren: () => import('./pages/customer-booking-history/customer-booking-history.module').then(m => m.CustomerBookingHistoryModule)
  },
  
  
  {
    path: 'ui',
    canActivate: [AuthGuard],
    loadChildren: () => import('./pages/ui-elements/ui-elements.module').then(m => m.UiElementsModule)
  },
  {
    path: '404',
    component: NotFoundComponent
  },
  {
    path: 'login',
    loadChildren: () => import('./pages/auth/auth.module').then(m => m.AuthModule)
  },
  {
    path: '**',
    redirectTo: '404'
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {
      //useHash: true,
      preloadingStrategy: PreloadAllModules
    })
  ],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
