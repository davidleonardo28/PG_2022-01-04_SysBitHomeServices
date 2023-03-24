import { TestBed } from '@angular/core/testing';

import { ContratantesService } from './contratante.service';

describe('ContratantesService', () => {
  let service: ContratantesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContratantesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
