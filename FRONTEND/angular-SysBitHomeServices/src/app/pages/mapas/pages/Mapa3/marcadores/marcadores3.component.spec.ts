import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Marcadores3Component } from './marcadores3.component';

describe('MarcadoresComponent', () => {
  let component: Marcadores3Component;
  let fixture: ComponentFixture<Marcadores3Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Marcadores3Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Marcadores3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
