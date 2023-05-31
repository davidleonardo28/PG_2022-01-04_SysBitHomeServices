import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FullScreen2Component } from './full-screen2.component';

describe('FullScreenComponent', () => {
  let component: FullScreen2Component;
  let fixture: ComponentFixture<FullScreen2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FullScreen2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FullScreen2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
