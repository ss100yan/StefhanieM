import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AngularDirectivesComponent } from './components/angular-directives/angular-directives.component';
import { DatabindingComponent } from './components/databinding/databinding.component';


/*
 *Angular routing allows us to achieve single page functionality by
  injecting a component's template into our index.html. When using routing in Angular, we use the built-in Router Module and create our Routes (which are just JavaScript objects). These routes create a relationship between a component and a path.
 */
const routes: Routes = [
  {
    component: AngularDirectivesComponent,
    path: "directives"
  },
  {
    component: DatabindingComponent,
    path: "databinding"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
