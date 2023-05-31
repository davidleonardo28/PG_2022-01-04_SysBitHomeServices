import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Marcadores2Component } from './marcadores2.component';

describe('MarcadoresComponent', () => {
  let component: Marcadores2Component;
  let fixture: ComponentFixture<Marcadores2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Marcadores2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Marcadores2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
