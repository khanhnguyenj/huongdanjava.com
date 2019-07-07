import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PComponent } from './p.component';
import { H1Component } from './h1.component';

@NgModule({
  declarations: [
    AppComponent,
    PComponent,
    H1Component
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
