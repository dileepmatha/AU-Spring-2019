import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpcomponentComponent } from './empcomponent.component';

describe('EmpcomponentComponent', () => {
  let component: EmpcomponentComponent;
  let fixture: ComponentFixture<EmpcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
