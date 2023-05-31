import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FullScreen4Component } from './full-screen4.component';

describe('FullScreenComponent', () => {
  let component: FullScreen4Component;
  let fixture: ComponentFixture<FullScreen4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FullScreen4Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FullScreen4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
