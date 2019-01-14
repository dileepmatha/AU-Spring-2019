import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeptcomponentComponent } from './deptcomponent.component';

describe('DeptcomponentComponent', () => {
  let component: DeptcomponentComponent;
  let fixture: ComponentFixture<DeptcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeptcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeptcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
