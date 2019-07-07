import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <div>{{ "Hello, " + getName() }}</div>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-interpolation';

  getName() {
    return 'Huong Dan Java';
  }
}
