import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccesoComponent } from './acceso/acceso.component';
import { ReservarComponent } from './reservar/reservar.component';
import { MisReservasComponent } from './mis-reservas/mis-reservas.component';
import { InicioComponent } from './inicio/inicio.component'; // Nuevo componente
import { RegistroComponent } from './registro/registro.component';
import { AuthGuard } from './auth.guard'; 

const routes: Routes = [
  { path: 'acceso', component: AccesoComponent },
  { path: 'reservar', component: ReservarComponent, canActivate: [AuthGuard] },  // Proteger la ruta
  { path: 'mis-reservas', component: MisReservasComponent, canActivate: [AuthGuard] },  // Proteger la ruta
  { path: 'registro', component: RegistroComponent },
  { path: '', component: InicioComponent, pathMatch: 'full' }, // Ruta por defecto
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
