import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContratantesComponent } from './contratantes.component';

describe('ContratantesComponent', () => {
  let component: ContratantesComponent;
  let fixture: ComponentFixture<ContratantesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContratantesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContratantesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
