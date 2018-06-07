import { Component } from '@angular/core';

import { OlcmService } from './olcm.service';
import { Observable } from 'rxjs';
import { Olcm } from './olcm';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'app';

  olcms: Observable<Olcm[]>;

  constructor(private olcmService: OlcmService ) {}

  ngOnInit() {
    this.olcms = this.olcmService.getOlcms();
  }

}
