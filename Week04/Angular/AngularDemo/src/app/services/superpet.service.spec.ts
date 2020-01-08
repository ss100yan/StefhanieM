import { TestBed } from '@angular/core/testing';

import { SuperpetService } from './superpet.service';

describe('SuperpetService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SuperpetService = TestBed.get(SuperpetService);
    expect(service).toBeTruthy();
  });
});
