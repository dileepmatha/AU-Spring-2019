import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { App1ComponentComponent } from './app1-component.component';

describe('App1ComponentComponent', () => {
  let component: App1ComponentComponent;
  let fixture: ComponentFixture<App1ComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ App1ComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(App1ComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
