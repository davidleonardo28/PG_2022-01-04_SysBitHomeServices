import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Marcadores4Component } from './marcadores4.component';

describe('MarcadoresComponent', () => {
  let component: Marcadores4Component;
  let fixture: ComponentFixture<Marcadores4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Marcadores4Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Marcadores4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
